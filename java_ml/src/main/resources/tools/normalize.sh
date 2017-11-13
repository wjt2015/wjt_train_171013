#!/bin/bash


#./normalize.sh /media/linux2014/E242B8EF42B8CA15/WJT_work/projects_1701020/wjt_train/wjt_train_171013/java_ml/src/main/java/javaweb/entity /media/linux2014/E242B8EF42B8CA15/WJT_work/projects_1701020/wjt_train/wjt_train_171013/java_ml/src/main/java/javaweb/mapper /media/linux2014/E242B8EF42B8CA15/WJT_work/projects_1701020/wjt_train/wjt_train_171013/java_ml/src/main/resources/mapper "*EntityMapper*" "s/Entity//g"

#./normalize.sh /media/linux2014/E242B8EF42B8CA15/WJT_work/projects_1701020/UGC_projects/ims_core_provider_171106/ims-provider/ims-core-dao/src/main/java/com/qunar/hotel/ims/dao/entity/authority /media/linux2014/E242B8EF42B8CA15/WJT_work/projects_1701020/UGC_projects/ims_core_provider_171106/ims-provider/ims-core-dao/src/main/java/com/qunar/hotel/ims/dao/mysql/authority /media/linux2014/E242B8EF42B8CA15/WJT_work/projects_1701020/UGC_projects/ims_core_provider_171106/ims-provider/ims-core-dao/src/main/resources/mapper "*EntityMapper*" "s/Entity//"


#删除Entity.java内多余的内容
dir=$1
fileList=`find ${dir} -name "*Entity.java"`

strArr=(createUser createTime updateUser updateTime available "set" "get" "return" "this" "}" "java.util.Date")


for file in ${fileList[*]}
do
echo "file=${file}"
for str in ${strArr[*]}
do
echo "str=${str}"
sed -i "/${str}/d" ${file}
#删除空行
sed -i "/^$/d" ${file}

done

echo "}" >> ${file}
done


#在Entity.java内添加注解和注释
strList=("import lombok.AllArgsConstructor;"  "import lombok.Getter;"  "import lombok.NoArgsConstructor;"  "import lombok.Setter;"  "import lombok.ToString;"  "import lombok.experimental.Accessors;"  "\/\*\* @author jintao.wang `date '+Date: %Y-%m-%d Time: %p%l:%M'` "  "\*\/"  "@AllArgsConstructor"  "@NoArgsConstructor"  "@Setter"  "@Getter" "@ToString" "@Accessors(chain = true)")
javaEntityFileList=`find ${dir} -name "*Entity.java"`
for file in ${javaEntityFileList[*]}
do
for str in ${strList[*]}
do
  echo "str=${str}"
  sed -i "s/public class/${str}\npublic class/" ${file}
done
done


#为EntityMapper文件改名

#mapperJavaDir=$2
#xmlDir=$3

mapperDirList=($2 $3)


#设置默认的文件名模式和修改模式
fileNamePattern="*EntityMapper*"
renamePattern="s/Entity//g"

#也可通过参数设置文件名模式和修改模式
if test $# -ge 4
then
    fileNamePattern=$4
fi

if test $# -ge 5
then
    renamePattern=$5
fi


for mapperDir in ${mapperDirList[*]}
do
    mapperFileList=`find ${mapperDir} -name ${fileNamePattern}`

    for file in ${mapperFileList[*]}
    do
        #更改相应的接口/类名
	    sed -i 's/EntityMapper/Mapper/g' ${file}
        #更改文件名
	    rename ${renamePattern} ${file}
    done
done

#修改成员名
echo "修改成员名--------"
sed -i 's/countofmember/countOfMember/g' $(grep -rl "countofmember" ${dir})
for mapperDir in ${mapperDirList[*]}
do
    echo "+++;mapperDir=${mapperDir}"
    sed -i 's/countofmember/countOfMember/g' $(grep -rlG "countofmember" ${mapperDir})

done

#修改java源代码
mapperJavaDir=$2
echo "mapperJavaDir=${mapperJavaDir};*******"
sed -i "s/insert\w*(/save(/g" $(grep -rlG "insert\w*(" ${mapperJavaDir})
sed -i "s/select\w*(/query(/g" $(grep -rlG "select\w*(" ${mapperJavaDir})
sed -i "s/ByPrimaryKey\w*(/(/g" $(grep -rlG "ByPrimaryKey\w*(" ${mapperJavaDir})

#修改mapper.xml文件
xmlDir=$3
echo "xmlDir=${xmlDir};---------"
sed -i "s/id=\"insert\w*\"/id=\"save\"/g" `grep -rlG "id=\"insert\w*\"" ${xmlDir}`
sed -i "s/id=\"select\w*\"/id=\"query\"/g" `grep -rlG "id=\"select\w*\"" ${xmlDir}`
sed -i "s/ByPrimaryKey\w*\"/\"/g" `grep -rlG "ByPrimaryKey" ${xmlDir}`

#sed -i "s/id=\"insert*\"/id=\"save\"/g" `grep -rl "id=\"insert\w*\"" /media/linux2014/E242B8EF42B8CA15/WJT_work/projects_1701020/wjt_train/wjt_train_171013/java_ml/src/main/resources/mapper`

#sed -i "s/id=\"insert*\"/id=\"save\"/g" /media/linux2014/E242B8EF42B8CA15/WJT_work/projects_1701020/wjt_train/wjt_train_171013/java_ml/src/main/resources/mapper/AccountMapper.xml


