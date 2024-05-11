package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;




public class kessi {
    Texture img;
    Vector2 position;
    float vy;
    float gravity;

    public kessi(){
        img = new Texture("кесси 1.png"); // объект картинки собаки
        position = new Vector2(100,380); // расположение собаки
        vy = 0; // скорость движения собаки вниз
        gravity = -0.7f; // как наша собака летит вниз
    }
    public void render(SpriteBatch batch){
        batch.draw(img, position.x, position.y);
    }

    public void update(){ // обновляем математику (положение собаки)
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            vy = 10; // подбрасываем собачку вверх
        }
        vy += gravity;// увиличиваем скорость движения собаки  вниз
        position.y += vy; // меняется позиция собаки
    }
    public void recreate(){
        position = new Vector2(100,380);
        vy = 0;
    }

}
