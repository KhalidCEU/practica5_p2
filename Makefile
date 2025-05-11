##
## KhalidCEU, 2025
## Makefile
## File description:
## Makefile
##

MVN_PROJNAME	=	practica5

MAIN_DIR	=	aplicacion

MAIN_CLASS	=	$(MAIN_DIR).Principal

SRC_DIR		=	./src

MVN_SOURCE	=	src

OUT_DIR		=	bin

LIB_DIR		=	./lib

DOC_DIR		=	html

JAR_FILE	=	$(MAIN_DIR).jar

all: executable

compile: clean
	mkdir $(OUT_DIR)
	find $(SRC_DIR) -name *.java | xargs javac -cp $(OUT_DIR):$(LIB_DIR) -d $(OUT_DIR)

executable: compile
	@echo '#!/bin/sh' > ./a.out
	@echo 'java -cp $(OUT_DIR) $(MAIN_CLASS) "$$@"' >> ./a.out
	@chmod +x ./a.out

jar: compile
	mkdir -p $(dir $(JAR_FILE))
	@echo "Manifest-Version: 1.0" > manifest.txt
	@echo "Main-Class: $(MAIN_CLASS)" >> manifest.txt
	@echo "Class-Path: . " >> manifest.txt
	@echo "" >> manifest.txt
	jar cvfm $(JAR_FILE) manifest.txt -C $(OUT_DIR) .

create_maven:
	mvn archetype:generate -DgroupId=${MVN_PROJNAME} -DartifactId=${MVN_SOURCE} -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

maven_test:
	cd src && mvn test

maven_run:
	cd src/ && mvn clean install

runjar: jar
	java -jar $(JAR_FILE)

javadoc: compile
	find . -type f -name "*.java" | xargs javadoc -d $(DOC_DIR) -encoding utf-8 -docencoding utf-8 -charset utf-8

debug: compile
	find $(SRC_DIR) -name *.java | xargs javac -g -cp $(OUT_DIR):$(LIB_DIR) -d $(OUT_DIR)
	cd bin; jdb -sourcepath ../src

re: clean all

clean:
	rm -rf $(OUT_DIR)
	rm -rf $(DOC_DIR)
	rm -f $(JAR_FILE)
	rm -rf *.dat
	rm -rf *.csv
	rm -f ./a.out