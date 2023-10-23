contenu=$(cat liste1.txt)

for nom in $contenu
do 
	echo "$nom"
	deluser --remove-home $nom
done