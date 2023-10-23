while read v_nom
do
	new_passwd=$(date +%s | sha256sum | head -c 8)
	echo "nom=$v_nom passwd=$new_passwd"
	adduser --disabled-password --ingroup t_users --gecos "" $v_nom
	echo $v_nom:$new_passwd | chpasswd
done < liste1.txt