
var gulp = require('gulp'),
    rename = require('gulp-rename'),
    through2=require("through2");
var fs = require('fs');
var path = require('path');
var merge = require('merge-stream');

function getFolders(dir) {
    return fs.readdirSync(dir)
        .filter(function(file) {
            return fs.statSync(path.join(dir, file)).isDirectory();
        });
}

function getFiles(dir) {
    return fs.readdirSync(dir)
        .filter(function(file) {
            return !fs.statSync(path.join(dir, file)).isDirectory();
        });
}

function getDeepFiles(dir) {
    //读取一级目录下的文件
    var arr = getFiles(dir)||[];
    //读取二级目录下的文件
    var folders = getFolders(dir);
    folders.map(function(folder) {
        //console.log(folder)
        var path = dir+folder+"/";
        var files = getFiles(path);
        files.map(function(file) {
            //console.log(file);
            arr.push(path+file);
        });
    });
    return arr;
}

gulp.task("demo",function(){
    //please change moduleName for yourself
    var moduleName = "saleRule";

    function createModuleWithDemo(moduleName){
        //输出目录
        var targetFolder = "./" + moduleName;
        //模板文件源目录
        var templateSourceFolder = "./demo/";
        //替换字符串
        function replaceTag(data) {
            //首字母大写
            var ucModuleName = moduleName.substring(0,1).toUpperCase()+moduleName.substring(1);
            data = data.replace(/Demo/mg, ucModuleName);
            return data.replace(/demo/mg, moduleName);
        }

        function modify(modifier) {
            return through2.obj(function (file, encoding, done) {
                var content = modifier(String(file.contents));
                file.contents = new Buffer(content);
                this.push(file);
                done();
            });
        }

        var templateFiles = getDeepFiles(templateSourceFolder);
        var tasks = templateFiles.map(function(file) {
            var newFile = replaceTag(file)
            gulp.src(file)
                .pipe(rename(newFile))
                .pipe(modify(replaceTag))
                .pipe(gulp.dest(targetFolder));
            return null;
        });

    }

    createModuleWithDemo(moduleName);
});
