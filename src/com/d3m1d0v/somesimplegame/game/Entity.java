package com.d3m1d0v.somesimplegame.game;

public class Entity {

    public Vector2D<Double> position;
    public Vector2D<Integer> dimension;
    public Vector2D<Integer> direction;
    public double velocity;
    public boolean isGravity; // Подвержен ли гравитации
    public boolean isMaterial; // Подвержен ли коллизиям
    public boolean isMovement; // Возможно ли движение

    public EntityState state = EntityState.STAY;

    public Entity(
            Vector2D<Double> position, Vector2D<Byte> direction, Vector2D<Integer> dimension,
            double velocity, boolean isGravity, boolean isMaterial, boolean isMovement
    ) {
        // TODO: initialize fields
    }

    public void startMove(Vector2D<Integer> direction) {
        if (state == EntityState.MOVE) return;

        this.direction = direction;

        state = EntityState.MOVE;
    }

    public void stopMove() {
        this.direction = null;

        state = EntityState.STAY;
    }
}
