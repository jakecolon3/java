build = build/minesweeper
src = src/main/java/minesweeper
cpath = CLASSPATH=./build
javac = $(cpath) javac -d ./build

run : $(build)/Main.class
	$(cpath) java minesweeper.Main 1

clean :
	rm -rf ./build

winexample : test/AWTExample.class
	$(cpath) java AWTExample

gridtest : $(build)/gui/GameGUI.class
	$(cpath) java minesweeper.gui.GameGUI 10 10

$(build)/Main.class : $(src)/Main.java $(build)/game/Game.class $(build)/gui/GameGUI.class
	$(javac) $(src)/Main.java

$(build)/game/Game.class : $(src)/game/Game.java $(build)/game/Board.class
	$(javac) $(src)/game/Game.java

$(build)/game/Board.class : $(src)/game/Board.java
	$(javac) $(src)/game/Board.java

$(build)/gui/GameGUI.class : $(src)/gui/GameGUI.java
	$(javac) $(src)/gui/GameGUI.java

build/AWTExample.class : src/test/java/AWTExample.java
	$(javac) src/test/java/AWTExample.java
