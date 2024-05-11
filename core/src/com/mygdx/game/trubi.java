package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class trubi {
    class Wallpair{
        Vector2 posit;
        float speed;
        int offset;
        Rectangle emptyspace;

        public Wallpair(Vector2 pos){
            posit = pos;
            speed = 2; // скорость движения труб
            offset = new Random().nextInt(250); // расположение косточек
            emptyspace = new Rectangle(posit.x, posit.y  - offset +300,50, betweenDistance);  // расстояние между трубами
        }
        public void update(){ // пересчет математики
            posit.x -= speed; // движения костей влево
            if(posit.x < -50){
                posit.x = 800;
                offset = new Random().nextInt(250);
            }
            emptyspace.y = posit.y - offset + 250;
            emptyspace.x = posit.x;

        }

    }
    static Wallpair[] obs;
    Texture txt;
    Texture tixit;
    int betweenDistance;
    public trubi(){
        txt = new Texture("кость.png"); // нижние кости
        tixit = new Texture("костэо.png"); // верхние кости
        obs = new Wallpair[4]; // массив из четырех костей на картинку
        betweenDistance = 250;
        int startposx = 400;  // кость начинается с центра  картинки
        for (int i = 0; i < obs.length; i++) { // инциализируем каждый элемент отдельно
            obs[i] = new Wallpair(new Vector2(startposx,0));
            startposx +=220;

        }
    }
    public void render(SpriteBatch batch){
        for (int i = 0; i < obs.length; i++) {
            batch.draw(txt, obs[i].posit.x, obs[i].posit.y - obs[i].offset); //нарисвали нижние кости
            batch.draw(tixit, obs[i].posit.x, obs[i].posit.y + betweenDistance +tixit.getHeight() - obs[i].offset); //нарисвали верхние  кости
        }
    }
    public void update(){ // вызывается метод, для каждой кости
        for (int i = 0; i < obs.length; i++) {
            obs[i].update();
        }
    }
    public void recreate(){ //метод пересоздает нашу игру, то есть отправляет ее в начальную точку после рестарта
        int startposx = 400;
        for (int i = 0; i < obs.length; i++) { // инциализируем каждый элемент отдельно
            obs[i] = new Wallpair(new Vector2(startposx, 0));
            startposx += 220;
        }
    }
}
