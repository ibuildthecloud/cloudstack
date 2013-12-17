mvn -P developer  -pl developer -Ddeploydb
sed s/3306/3307/g utils/conf/db.properties > utils/conf/db.properties.override
mvn -P developer  -pl developer -Ddeploydb
