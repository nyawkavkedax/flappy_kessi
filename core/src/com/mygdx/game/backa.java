package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class backa {
    class bgpicture{ // создаем класс, чтобы код был структурированным
        private Texture tx;
        private Vector2 pos;

        public bgpicture(Vector2 pos){ // инициализируем координаты
            tx = new Texture("фон.jpg"); // объект нашей картинки
            this.pos = pos; // считываем изначальную позицию картинки

        }
    }

    private int speed; // создали скорость передвижения картинки
    private bgpicture[] backs;// массив из объектов bgpicture
    public backa(){

        speed = 4; // скорость передвежения картинки
        backs = new bgpicture[2]; // наш массив из двух картинок
        backs[0] = new bgpicture(new Vector2(0,0)); // координаты первой картинки
        backs[1] = new bgpicture(new Vector2(800,0)); // второй

    }
    public void render(SpriteBatch batch){
        for (int i = 0; i < backs.length; i++) {
            batch.draw(backs[i].tx, backs[i].pos.x, backs[i].pos.y);// отрисовываем две картинки

        }
    }
    public void update() { // тут прописываем наше передвижение картинки
        for (int i = 0; i < backs.length; i++) {
            backs[i].pos.x -= speed; // картинка съезжает
        }
        if (backs[0].pos.x < -800) { // когда одна картинка заканчивается, идет вторая картинка
            backs[0].pos.x = 0;
            backs[1].pos.x = 800;
        }
    }
}
