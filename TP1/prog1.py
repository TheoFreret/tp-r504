import fonctions as f

print("Hello, World!")

print("calcule de a^b :")
v1 = int(input("Valleur de a : "))
v2 = int(input("Valleur de b : "))

res = f.puissance(v1,v2)

while True :
	Nb = int(input("Entrer un nombre a mettre au carree : "))
	NbPower = pow(Nb, 2)
	print("Le carree de" , Nb , "est =" , NbPower)
