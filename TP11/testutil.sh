#!/bin/bash

PS3='Selectionnez: '
choix=("Verifier l'existance d'un utilisateur" "Connaitre l'UID d'un utilisateur" "Quitter")
select opt in "${choix[@]}"
do
	case $opt in
		"Verifier l'existance d'un utilisateur")
			echo "Quel utilisateur verifier ?"
			read usernom
			id $usernom > /dev/null
			if [ $? = 1 ]
			then
				echo "existe pas"
			else
				echo "existe"
			fi
			;;
		"Connaitre l'UID d'un utilisateur")
			echo "Connaitre"
			read usernom
			id -u $usernom
			;;
		"Quitter")
			echo "Quitter"
			break
			;;
		*) echo "choix $REPLY est invalide";;
	esac
done