package core;

import menus.MainMenu;

public class Main
{
	public static void main(String[] args)
	{
		Renderer gfxControl = new Renderer();
		gfxControl.setMenu(new MainMenu(gfxControl));
		//TODO dogs should vote
	}
}
