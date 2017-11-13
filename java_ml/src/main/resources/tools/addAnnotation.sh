#!/bin/bash
#添加通用注解

#@AllArgsConstructor
#@NoArgsConstructor
#@Setter
#@Getter
#@EqualsAndHashCode
#@Accessors(chain = true)

#import lombok.AllArgsConstructor;
#import lombok.Getter;
#import lombok.NoArgsConstructor;
#import lombok.Setter;
#import lombok.ToString;
#import lombok.experimental.Accessors;

##匹配行前加
#sed -i '/allow 361way.com/iallow www.361way.com' the.conf.file
##匹配行前后
#sed -i '/allow 361way.com/aallow www.361way.com' the.conf.file
#而在书写的时候为便与区分，往往会在i和a前面加一个反加一个反斜扛 。代码就变成了：
#
#sed -i '/2222222222/a\3333333333' test.txt
#sed -i '/2222222222/i\3333333333' test.txt

#这就就可以很方便的看出要在某一行前或某一行后加入什么内容 。不过经常我记不住a 、i 那个是前那个是后。我的记法是a = after ，i = in front 。这样就知道 i 是前，a 是后了。不过官方的man文件里不是这样解释的，man文件里是这样解释的：
#
#a
#text   Append text, which has each embedded newline preceded by a backslash.
#i
#text   Insert text, which has each embedded newline preceded by a backslash.
#而且其可以配合find查找的内容处理，如下：
#
#find . -name server.xml|xargs sed -i '/directory/i       <!--'
#find . -name server.xml|xargs sed -i '/pattern="%h/a       -->'
#sed -i "s/public class/@AllArgsConstructor\npublic class/" /media/linux2014/E242B8EF42B8CA15/WJT_work/projects_1701020/wjt_train/wjt_train_171013/java_ml/src/main/java/javaweb/entity/AuthorityEntity.java


strList=("import lombok.AllArgsConstructor;"  "import lombok.Getter;"  "import lombok.NoArgsConstructor;"  "import lombok.Setter;"  "import lombok.ToString;"  "import lombok.experimental.Accessors;"  "\/\*\* @author jintao.wang `date '+Date: %Y-%m-%d Time: %p%l:%M'` "  "\*\/"  "@AllArgsConstructor"  "@NoArgsConstructor"  "@Setter"  "@Getter" "@ToString" "@Accessors(chain = true)")


dir=$1
javaEntityFileList=`find ${dir} -name "*Entity.java"`
for file in ${javaEntityFileList[*]}
do
for str in ${strList[*]}
do
  echo "str=${str}"
  sed -i "s/public class/${str}\npublic class/" ${file}
done

done




