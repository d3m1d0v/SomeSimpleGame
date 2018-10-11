package com.d3m1d0v.somesimplegame.game;

import com.d3m1d0v.somesimplegame.game.engines.AIEngine;
import com.d3m1d0v.somesimplegame.game.engines.GraphicsEngine;
import com.d3m1d0v.somesimplegame.game.engines.InputEngine;
import com.d3m1d0v.somesimplegame.game.engines.PhysicsEngine;

public class GameEngine {

    public GraphicsEngine graphics = new GraphicsEngine();
    public PhysicsEngine physics = new PhysicsEngine();
    public InputEngine input = new InputEngine();
    public AIEngine ai = new AIEngine();

    private boolean isPaused = false;
    private boolean isStopped = false;

    public GameEngine() {
        // TODO: initialize game world
    }

    public void start() throws InterruptedException {
        graphics.start();
        physics.start();
        input.start();
        ai.start();

        while (!isStopped) {
            nextTick();

            Thread.sleep(1);
        }
    }

    private void nextTick() {
        if (isPaused) return;

        input.nextTick();
        ai.nextTick();
        physics.nextTick();
        graphics.nextTick();
    }

    public void pause() {
        isPaused = !isPaused;
    }

    public void stop() {
        isStopped = !isStopped;
    }
}
