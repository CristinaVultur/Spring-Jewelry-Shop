# Spring-Jewelry-Shop
	proiect ce prezinta un magazine online de Bijuterii.

Modele:

Buyer -> cumparatorul - Entitate
-	fields:
o	id
o	name
o	email
-	are asociat un ShoppingCart – coloanal in tabelul buyer OnetoOne
-	si are o lista cu comenzile ce le-a plasat: orders - OneToMany

Distributor -> distribuitor de bijuterii -Entitate
-	fields:
o	id
o	name
-	are asociat un ContactInfo pentru datele sale de contact – coloanal se afla in tabelul distributor OneToOne

ContactInfo -> datele de contact a distribuitorului – Entitate
-	fields:
o	id
o	city
o	street
o	streetNumber
-	are asociat un Distribuitor de care apartine

Jewelry -> bijuterie – Entitate
-	fields:
o	id
o	name
o	type
o	price
-	are asociat un Distribuitor de care apartine – ManyToOne

Order -> entitate
-	fields: 
o	id
o	total
o	status – tip ENUM OrderStatus: PROCESSED, SHIPPED, CANCELLED, RECEIVED;
o	jewelries – lista cu bijtuerii a comenzii respective ManyToMany
o	buyer – ManyToOne

Shopping Cart: ->entitate
-	fields: 
o	id
o	total
o	jewelries – lista cu bijtuerii a comenzii respective ManyToMany
o	buyer –OneToMany


Jewelry Controller
-	Afisam toate bijuteriile existente -> in acelasi request putem cauta si dupa nume prin request parameter: name
-	Afisam o bijuterie dupa Id ul ei
Distributor Controller:
-	Afisam toti distribuitorii -> in acelasi request putem cauta si dupa orasul lor prin request parameter: city
-	Afistam distribuitorul dupa nume
Shopping Cart Contoller:
-	Afisam cosul  de cumparaturi , cu id-ul dat ca path variable, cu ce se afla in el
-	Adaugam un produs in cos
-	Stergem un produs din cos
Order Controller:
-	Dam o comanda noua -> ca parametru dam id-ul cosului de cumparaturi dupa care vrem sa dam comanda
-	Afisam toate comenzile ale unui cumparator
		
