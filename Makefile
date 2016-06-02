# Sample Makefile for the WACC Compiler lab: edit this to build your own comiler
# Locations

# use Java 8 please kthnxbai#
JAVA_BIN    := /usr/lib/jvm/jdk-8-oracle-x64/bin

ANTLR_DIR	:= antlr
SOURCE_DIR	:= src
OUTPUT_DIR	:= bin

# Tools

ANTLR	:= antlrBuild
FIND	:= find
RM  := rm -rf
MKDIR	:= mkdir -p
JAVA	:= $(JAVA_BIN)/java
JAVAC	:= $(JAVA_BIN)/javac

JFLAGS	:= -sourcepath $(SOURCE_DIR) -d $(OUTPUT_DIR) -cp lib/antlr-4.4-complete.jar

# the make rules

.PHONY: all

all: rules

# runs the antlr build script then attempts to compile all .java files within src
rules:
	cd $(ANTLR_DIR) && ./$(ANTLR) 
	$(FIND) $(SOURCE_DIR) -name '*.java' > $@
	$(MKDIR) $(OUTPUT_DIR)
	$(JAVAC) $(JFLAGS) @$@
	$(RM) rules

clean:
	$(RM) rules $(OUTPUT_DIR)


