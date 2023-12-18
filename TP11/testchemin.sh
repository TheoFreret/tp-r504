#!/bin/bash

IFS="/"; read -a tab <<< $1
#echo ${tab[@]}
x=""

for (( i=1; i<${#tab[@]}; i++ ))
do
	x=$a/
	IFS=" "; a="$x${tab[$i]}"

	echo "$a"
	if [ -e "$a" ]
	then
		echo "$a est un dossier valide"
	else
		echo "Chemin invalide, le dossier ${tab[$i]} dans $a n'existe pas"
	fi
	echo
	#sleep 0.3
done