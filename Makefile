# COMMANDES #
JAVAC = javac
# note $$ to get a single shell $
JAVAC_OPTIONS = -d build -cp build -sourcepath src   -encoding UTF-8 -implicit:none
JAVA = java
JAVA_OPTIONS_W = -cp build 
JAVA_OPTIONS = -cp build 
JAR = jar
EXEC_JAR = ${JAVA} -jar
SUP = rm -rf

# CHEMINS RELATIFS
SRC = src/fr/amoussa/Demineur
BUILD = build/fr/amoussa/Demineur
DOC = doc/fr/amoussa/Demineur
BUILD_WINDOWS = "build/fr/amoussa/Demineur/"
# CHOIX NOMS
JAR_FILE =  Demineur.jar  



# BUT PAR DEFAUT #
run : ${BUILD}/Main.class
	${JAVA} ${JAVA_OPTIONS} fr.amoussa.Demineur.Main

run_W :${BUILD}/Main.class
	${JAVA} ${JAVA_OPTIONS_W} fr.amoussa.Demineur.Main

jar: ${JAR_FILE}
	${EXEC_JAR} ${JAR_FILE}

# POUR WINDOWS#
clean_W : 
	rd /s /q ${BUILD_WINDOWS}

clean_jar_W:
	del Demineur.jar

#POUR LINUX 
clean : 
	rm -r build/*

clean_jar:
	rm Demineur.jar
	
# REGLES DE DEPENDANCE #

${BUILD}/Main.class:  ${SRC}/Main.java \
	${BUILD}/VIEW/Accueil.class \
	${BUILD}/CONTROLLER/Observateur_accueil.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/Main.java


## VIEW ##
${BUILD}/VIEW/Accueil.class:  ${SRC}/VIEW/Accueil.java \
	${BUILD}/VIEW/Selection.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/VIEW/Accueil.java

${BUILD}/VIEW/Selection.class:  ${SRC}/VIEW/Selection.java \
	${BUILD}/CONTROLLER/Observateur_Selection.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/VIEW/Selection.java

${BUILD}/VIEW/Fenetre_Partie.class:  ${SRC}/VIEW/Fenetre_Partie.java \
		${BUILD}/VIEW/Grille.class \
		${BUILD}/VIEW/Compteur.class \
		${BUILD}/CONTROLLER/GameButtonListener.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/VIEW/Fenetre_Partie.java

${BUILD}/VIEW/Grille.class:  ${SRC}/VIEW/Grille.java \
		${BUILD}/VIEW/Case.class 
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/VIEW/Grille.java

${BUILD}/VIEW/Case.class:  ${SRC}/VIEW/Case.java \
		${BUILD}/CONTROLLER/Observateur_case.class \
		${BUILD}/UTILS/Icone.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/VIEW/Case.java

${BUILD}/VIEW/Compteur.class: ${SRC}/VIEW/Compteur.java
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/VIEW/Compteur.java

${BUILD}/VIEW/PopupResultat.class: ${SRC}/VIEW/PopupResultat.java \
	${BUILD}/CONTROLLER/ObservateurFinalSelection.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/VIEW/PopupResultat.java


## CONTROLLER ##


${BUILD}/CONTROLLER/Observateur_accueil.class: ${SRC}/CONTROLLER/Observateur_accueil.java 
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/CONTROLLER/Observateur_accueil.java

${BUILD}/CONTROLLER/Observateur_Selection.class: ${SRC}/CONTROLLER/Observateur_Selection.java \
	${BUILD}/VIEW/Fenetre_Partie.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/CONTROLLER/Observateur_Selection.java

${BUILD}/CONTROLLER/Observateur_case.class: ${SRC}/CONTROLLER/Observateur_case.java \
	${BUILD}/MODEL/GridModel.class \
	${BUILD}/VIEW/PopupResultat.class
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/CONTROLLER/Observateur_case.java
  
${BUILD}/CONTROLLER/ObservateurFinalSelection.class: ${SRC}/CONTROLLER/ObservateurFinalSelection.java 
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/CONTROLLER/ObservateurFinalSelection.java

${BUILD}/CONTROLLER/GameButtonListener.class: ${SRC}/CONTROLLER/GameButtonListener.java 
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/CONTROLLER/GameButtonListener.java

## MODEL ##

${BUILD}/MODEL/GridModel.class: ${SRC}/MODEL/GridModel.java 
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/MODEL/GridModel.java

## UTILS ##

${BUILD}/UTILS/Icone.class: ${SRC}/UTILS/Icone.java 
	${JAVAC} ${JAVAC_OPTIONS} ${SRC}/UTILS/Icone.java


# ## JARS ##

 ${JAR_FILE} : ${BUILD}/Main.class
	${JAR} cvfe ${JAR_FILE}  fr.amoussa.Demineur.Main -C build .  -C res .

