# gulp code generator
 code generator by gulp!
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
gulp.task("demo",function(){
    //please change moduleName for yourself
    var moduleName = "order";

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
```