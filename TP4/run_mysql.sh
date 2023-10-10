docker run -d \
	-p 3307:3306 \
	-v vol-sql-demo:/var/lib/mysql \
	--name tp4-sql \
	--env MYSQL_ROOT_PASSWORD=foo \
	--network net-tp4 \
	mysql

if [ $? != 0 ]
then
	exit 1
fi