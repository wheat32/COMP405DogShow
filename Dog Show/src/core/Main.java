package core;

import graphics.Renderer;
import menus.MainMenu;

public class Main
{
	public static void main(String[] args)
	{
		Renderer gfxControl = new Renderer();
		MainMenu mainMenu = new MainMenu(gfxControl);
	}
}
