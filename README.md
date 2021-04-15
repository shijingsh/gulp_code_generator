# gulp code generator
 code generator by gulp!
 简单的设置变量，代码替换
## Installation
```bash
$ npm install gulp -g
```

```bash
$ cd gulp_code_generator
$ npm install
```
## generator
```bash
$ gulp demo
```

```javascript
gulp.task('demo', done => {
    //please change variable for yourself
    var moduleName = "integralRecord";  //模块名
    var packageName = "integral";       //包名
    var entityPackageName = "integral"; //实体类所在包名
    var cnGlobalApiName = "积分管理";   //中文全局模块名
    var cnApiName = "积分记录";         //中文子模块名
    console.log('moduleName:'+moduleName);
    console.log('packageName:'+packageName);
    console.log('entityPackageName:'+entityPackageName);
    function createModuleWithDemo(moduleName){
        //输出目录
        var targetFolder = "./output" ;
        //模板文件源目录
        var templateSourceFolder = "./demoPackage/";
        //替换字符串
        function replaceTag(data) {
            //首字母大写
            var ucModuleName = moduleName.substring(0,1).toUpperCase()+moduleName.substring(1);
            //替换包名
            data = data.replace(/demoPackage/mg, packageName);
            data = data.replace(/demoEntityPackage/mg, entityPackageName);
            //替换注释
            data = data.replace(/cnGlobalApiName/mg, cnGlobalApiName);
            data = data.replace(/cnApiName/mg, cnApiName);
            //替换大写
            data = data.replace(/Demo/mg, ucModuleName);
            //替换小写
            return data.replace(/demo/mg, moduleName);
        }

        function modify(modifier) {
            return through2.obj(function (file, encoding, done) {
                var content = modifier(String(file.contents));
                file.contents = new Buffer.from(content);
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
    done();
});
```
