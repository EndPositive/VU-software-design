package main.java.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.badlogic.gdx.graphics.GL20.GL_COLOR_BUFFER_BIT;

public class EasterEggScreen extends ScreenAdapter {
    SpriteBatch batch;
    BitmapFont font;
    Texture img;

    public EasterEggScreen() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        img = new Texture("./resources/tibi.png");

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(img, 0, 0, 200, 200);
        font.draw(batch, "This is an easter egg", 20, 250);
        batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) Gdx.app.exit();
    }
}
