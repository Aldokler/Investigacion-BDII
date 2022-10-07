import random

random.seed(777)

nombres = ["Maria","Jose","Luis","Ana","Carlos","Juan","Jorge","Victor","Gerardo","Rafael","Mario","Oscar","Manuel","Carmen","Miguel","Francisco","Rosa","Marco","Laura","Marta","Flor","Ronald","Alvaro","Alexander","William","Andrea","Marvin","Adriana","Eduardo","Olga","Karla","Elizabeth","David","Daniel","Jonathan","Karen","Silvia","Sandra","Sonia","Ricardo","Katherine","Luz","Edgar","Edwin","Mauricio","Fernando","Esteban","Javier","Michael","Jesus","Roberto","Walter","Andres","Diego","Alejandro","Sergio","Guillermo","Jessica","Julio","Evelyn","Adrian","Henry","Pablo","Shirley","Johnny","Christian","Gustavo","Alejandra","Rodrigo","Carolina","Roger","Rodolfo","Margarita","Freddy","Ligia","Marcos","Allan","Roxana","Virginia","Gabriela","Maritza","Patricia","Erick","Blanca","Isabel","Diana","Wendy","Cesar","Pedro","Marjorie","Cindy","Karol","Roy","Jenny","Cristian","Tatiana","Alberto","Bryan","Miriam","Marlene","Grettel","Yamileth","Antonio","Alexis","Natalia","Monica","Mayra","Kevin","Orlando","Daniela","Josue","Melissa","Giovanni","Yesenia","Jacqueline","Jennifer","Rolando","Johanna","Marcela","German","Kenneth","Stephanie","Rebeca","Kimberly","Jeannette","Ramon","Angie","Franklin","Hilda","Gabriel","Hector","Nelson","Damaris","Ingrid","Vilma","Marianela","Martin","Cecilia","Hazel","Rosibel","Raquel","Maribel","Enrique","Viviana","Leonardo","Angela","Juana","Rigoberto","Ruth","Omar","Nuria","Hugo","Fabian","Angel","Alfredo","Lidia","Marlon","Nancy","Jairo","Teresa","Erika","Sara","Norma","Gladys","Alicia","Lilliam","Gilberto","Steven","Maureen","Nidia","Giselle","Flora","Paola","Felix","Grace","Lorena","Yolanda","Veronica","Alba","Melvin","Eliecer","Mariana","Daisy","Eric","Irene","Susana","Jean","Vera","Karina","Mercedes","Vanessa","Rita","Mariela","Gilbert","Jimmy","Rocio","Paula","Hernan","Mayela","Ronny","Jeffry","Jaime","Jason","Anthony","Cristina","Raul","Andrey","Danilo","Ivan","Gloria","Claudio","Ileana","Douglas","Iris","Dennis","Ericka","Denis","Lucia","Alexandra","Marisol","Hellen","Priscilla","Alfonso","Danny","Fabio","Teresita","Mireya","Marilyn","Dora","Emilce","Santos","Johan","Dayana","Elena","Fanny","Cynthia","Alex","Claudia","Joselyn","Zaida","Yadira","Leonel","Wilber","Pamela","Doris","Armando","Leticia","Julia","Arturo","Angelica","Martha","Alonso","Carol","Dagoberto","Elias","Irma","Maricela","Fabiola","Guido","Aracelly","Elsa","Dinorah","Edith","Aida","Noemy","Efrain","Adolfo","Wilson","Vivian","Beatriz","Emilia","Nelly","Isaac","Clara","Anabelle","Christopher","Cinthya","Victoria","Sofia","Eladio","Luisa","Leidy","Sharon","Leda","Haydee","Bernardo","Arnoldo","Didier","Brayan","Humberto","Norman","Catalina","Maikol","Graciela","Asdrubal","Gonzalo","Ernesto","Ruben","Gerardina","Santiago"]
apellidos = ["Rodriguez","Vargas","Jimenez","Mora","Rojas","Gonzalez","Sanchez","Hernandez","Ramirez","Castro","Lopez","Araya","Solano","Alvarado","Chaves","Perez","Morales","Campos","Quesada","Gomez","Arias","Zuñiga","Quiros","Fernandez","Salazar","Villalobos","Brenes","Gutierrez","Garcia","Alfaro","Vega","Aguilar","Calderon","Valverde","Chavarria","Alvarez","Castillo","Salas","Espinoza","Martinez","Solis","Murillo","Soto","Chacon","Cordero","Mendez","Herrera","Monge","Montero","Barrantes","Segura","Madrigal","Diaz","Marin","Porras","Fallas","Navarro","Rivera","Torres","Fonseca","Nuñez","Calvo","Delgado","Ruiz","Hidalgo","Arce","Obando","Zamora","Molina","Muñoz","Cruz","Vasquez","Bonilla","Picado","Miranda","Gamboa","Badilla","Umaña","Mena","Esquivel","Corrales","Flores","Camacho","Arroyo","Chinchilla","Guzman","Granados","Cerdas","Acuña","Cascante","Abarca","Elizondo","Barquero","Arguedas","Bolaños","Ortiz","Blanco","Carvajal","Leon","Duran","Cortes","Ureña","Aguero","Cespedes","Villegas","Romero","Bermudez","Serrano","Barboza","Artavia","Sandi","Venegas","Angulo","Mata","Alpizar","Matarrita","Sequeira","Montoya","Ugalde","Vindas","Sibaja","Reyes","Ortega","Arrieta","Viquez","Varela","Rosales","Moya","Sandoval","Benavides","Mendoza","Orozco","Garro","Garita","Carrillo","Guevara","Morera","Duarte","Coto","Masis","Guerrero","Retana","Azofeifa","Cordoba","Loria","Padilla","Paniagua","Fuentes","Cambronero","Leiva","Sanabria","Trejos","Avila","Ulate","Carranza","Piedra","Guillen","Oviedo","Cubillo","Cubero","Naranjo","Ulloa","Matamoros","Carmona","Solorzano","Mesen","Carballo","Lobo","Baltodano","Robles","Mejias","Contreras","Amador","Pereira","Bustos","Madriz","Ramos","Sancho","Valerio","Suarez","Leiton","Acosta","Lara","Saborio","Aguirre","Saenz","Rios","Briceño","Marchena","Villarreal","Medina","Lizano","Meza","Peña","Godinez","Moreno","Cedeño","Roman","Jara","Melendez","Mejia","Ledezma","Zumbado","Loaiza","Barahona","Prado","Mayorga","Arguello","Rivas","Bejarano","Centeno","Berrocal","Zeledon","Tenorio","Conejo","Pacheco","Moraga","Pizarro","Montenegro","Villalta","Bogantes","Fajardo","Guido","Aleman","Guadamuz","Portuguez","Juarez","Palma","Santamaria","Cardenas","Anchia","Parra","Ocampo","Barrientos","Chaverri","Acevedo","Ovares","Canales","Montiel","Corella","Montes","Castrillo","Estrada","Luna","Ballestero","Moreira","Figueroa","Cabezas","Urbina","Leal","Obregon","Peraza","Jarquin","Valerin","Vallejos","Ceciliano","Palacios","Prendas","Bravo","Siles","Peralta","Maroto","Meneses","Redondo","Ordoñez","Solera","Corea","Viales","Hurtado","Leandro","Beita","Arauz","Aragon","Coronado","Barrios","Astua","Jaen","Sojo","Sosa","Avendaño","Navarrete","Cabrera","Davila","Altamirano","Silva","Cervantes","Borbon","Velasquez","Brown","Najera","Enriquez","Otarola","Cisneros","Chevez","Bustamante","Huertas","Medrano","Valenciano","Tencio","Pineda","Pastor","Ojeda","Suzuki","Ferrer","Iglesias","Oda","Miyamoto","Stark","Wayne","Banner","Parker","Turing","Babbage","Tesla","Pendragon","Nightingale","Edison"]
marital = ["casado", "soltero", "divorciado"]
paises = ["Mexico", "Estados Unidos", "Nicaragua", "Cuba", "El Salvador", "Argentina", "Venezuela", "España", "Panamá"]
decision = [True, False]
idTail = 10000000

f = open("pipol.txt", "a")

for i in apellidos:
    for j in apellidos:
        idHead = random.randint(1,9)
        pais = "Costa Rica"
        if idHead == 8 or idHead == 9:
            pais = random.choice(paises)
        name = random.choice(nombres)
        if random.choice(decision):
            name += " " + random.choice(nombres)
        civil = random.choice(marital)
        bdia = random.randint(1, 28)
        bmes = random.randint(1, 12)
        bano = random.randint(1930, 2020)
        f.write("{ \"create\":{\"_index\": \"person\", \"_id\": \"")
        f.write(str(idHead))
        f.write(str(idTail))
        f.write("\"} }")
        f.write('\n')
        f.write("{\"id\": \"")
        f.write(str(idHead))
        f.write(str(idTail))
        f.write("\",\"name\": \"" + name + "\",\"lastname\": \"" + i + " " + j + "\",\"marital\": \"" + civil + "\"")
        f.write(",\"birthdate\": [")
        f.write(str(bdia))
        f.write(",")
        f.write(str(bmes))
        f.write(",")
        f.write(str(bano))
        f.write("],")
        if random.choice(decision):
            ddia = random.randint(1, 28)
            dmes = random.randint(1, 12)
            dano = random.randint(bano+1, 2022)
            f.write("\"deathdate\": [")
            f.write(str(ddia))
            f.write(",")
            f.write(str(dmes))
            f.write(",")
            f.write(str(dano))
            f.write("],")
        f.write("\"nation\": \"" + pais + "\"}")
        f.write('\n')
        idTail+=1

f.close()