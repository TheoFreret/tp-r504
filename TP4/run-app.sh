docker run \
	--name tp4-app \
	--network net-tp4 \
	-p 5000:5000 \
	im-tp4

if [ $? != 0 ]
then
	echo "Il y a un erreur avec le conteneur"
	exit 1
fi
