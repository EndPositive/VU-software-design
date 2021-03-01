package main.java.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.badlogic.gdx.graphics.GL20.GL_COLOR_BUFFER_BIT;

public class EasterEggScreen extends ScreenAdapter {
    final SpriteBatch batch;
    final BitmapFont font;
    final Texture tibiImg, chrisImg, jopImg;

    public EasterEggScreen() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        tibiImg = new Texture("./resources/tibi.png");
        chrisImg = new Texture("./resources/chris.png");
        jopImg = new Texture("./resources/jop.png");
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(tibiImg, 0, 0, 200, 200);
        batch.draw(chrisImg, 200, 0, 200, 200);
        batch.draw(jopImg, 400, 0, 200, 200);
        font.draw(batch, "This is an easter egg", 20, 250);
        batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) Gdx.app.exit();
    }
}
