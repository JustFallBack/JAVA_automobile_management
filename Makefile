# Source du projet :
SRC_DIR := TOYAUDI/src/main/java

# Source des fichiers tests :
TEST_DIR := TOYAUDI/src/test/java

# Répertoire de sortie des fichiers compilés
OUT_DIR := TOYAUDI/target

JAVA_FILES := $(shell find $(SRC_DIR) -name '*.java')
JAVA_FILES += $(shell find $(TEST_DIR) -name '*.java')
CLASS_FILES := $(JAVA_FILES:$(SRC_DIR)/%.java=$(OUT_DIR)/%.class)
CLASS_FILES += $(JAVA_FILES:$(TEST_DIR)/%.java=$(OUT_DIR)/%.class)

# Commande de compilation :
JAVAC := javac -d $(OUT_DIR)

# Règles de compilation des fichiers Java :
$(OUT_DIR)/%.class: $(SRC_DIR)/%.java
	$(JAVAC) $<

$(OUT_DIR)/%.class: $(TEST_DIR)/%.java
	$(JAVAC) $<

all: $(CLASS_FILES)

clean:
	rm -rf $(OUT_DIR)/*