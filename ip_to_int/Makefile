# Windows env

# Variables
JAVAC = javac
JAVA = java
SRC_DIR = src
TEST_DIR = test
BUILD_DIR = build
MAIN_CLASS = Main
MAIN_TEST_CLASS = MainTest
BUCKET_FILE = sources.txt
ARGS =

# Targets
.PHONY: all compile run test clean

all: compile

compile:
	mkdir $(BUILD_DIR)
	dir /b /s *.java > $(BUCKET_FILE)
	$(JAVAC) -d $(BUILD_DIR) @$(BUCKET_FILE)
	del $(BUCKET_FILE)

run:
	$(JAVA) -cp $(BUILD_DIR) $(MAIN_CLASS) $(ARGS)

test:
	$(JAVA) -ea -cp $(BUILD_DIR) $(MAIN_TEST_CLASS)

clean:
	rmdir /s /q $(BUILD_DIR)
