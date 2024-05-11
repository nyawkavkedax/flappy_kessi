package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;



public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	backa bg;
	kessi kessi; // 1. создавляем собаку, 2. создаем в креате . 3. отрисовываем в рендере 4. математика в апдейте
	trubi trubi;
	boolean gameOver;
	Texture restartik;
	@Override
	public void create () { // создаем объекты
		batch = new SpriteBatch();
		bg= new backa();
		kessi = new kessi();
		trubi = new trubi();
		gameOver = false;
		restartik = new Texture("текст.png");
	}

	@Override
	public void render () {
		update();
		ScreenUtils.clear(1, 1, 1, 1); // цвет нашего фона
		batch.begin();
		bg.render(batch);
		kessi.render(batch);
		trubi.render(batch);
		if (!gameOver ){
			kessi.render(batch);
		}
		else{
			batch.draw(restartik,200,200);
		}
		batch.end();

	}
	public void update() {
		bg.update();
		kessi.update();
		trubi.update();
		for (int i = 0; i < trubi.obs.length; i++) { // в цикле наша собака ударяется об стенки и игра заканчвается
			if(kessi.position.x > trubi.obs[i].posit.x && kessi.position.x < trubi.obs[i].posit.x + 50 ){
				if(!trubi.obs[i].emptyspace.contains(kessi.position)){
					gameOver = true;
				}
			}
		}
		if(kessi.position.y < 0 || kessi.position.y > 600){
			gameOver = true;
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && gameOver){ // создаем кнопку space для рестарта
			recreate();
		}

	}
	
	@Override
	public void dispose () {
		batch.dispose();

	}
	public void recreate(){
		kessi.recreate();
		trubi.recreate();
		gameOver = false;
	}
}
