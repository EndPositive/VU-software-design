package main.java.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

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
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyUp(int keycode) {
                if (keycode == Input.Keys.ESCAPE) Gdx.app.exit();
                return true;
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL_COLOR_BUFFER_BIT);

        ShapeRenderer shapeRenderer = new ShapeRenderer();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.ORANGE);
        shapeRenderer.rect(65, 233, 30, 20);
        shapeRenderer.end();

        batch.begin();
        batch.draw(tibiImg, 0, 0, 200, 200);
        batch.draw(chrisImg, 200, 0, 200, 200);
        batch.draw(jopImg, 400, 0, 200, 200);

        font.setColor(Color.WHITE);
        font.draw(batch, "Easter", 20, 250);

        font.setColor(Color.BLACK);
        font.draw(batch, "egg", 67, 250);

        batch.end();
    }
}
