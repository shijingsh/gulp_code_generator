
var gulp = require('gulp'),
    rename = require('gulp-rename'),
    through2=require("through2");

gulp.task("demo",function(){

    var moduleName = "order";


    function createWithDemo(moduleName){

        //输出目录
        var targetFolder = "." + moduleName;

        //模板文件源目录
        var templateSourceFolder = "./java/com/mg/";

        //替换字符串
        function replaceTag(data) {
            data = data.replace(/Demo/mg, moduleName);
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


        gulp.src(templateSourceFolder + "demo/controller/DemoController.java")
            .pipe(rename(moduleName + ".java"))
            .pipe(modify(replaceTag))
            .pipe(gulp.dest(targetFolder + moduleName));

    }

    createWithDemo(moduleName);
});
