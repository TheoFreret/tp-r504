contenu=$(cat liste1.txt)

for nom in $contenu
do 
	echo "$nom"
	adduser --disabled-password --ingroup t_users --gecos "" $nom
done