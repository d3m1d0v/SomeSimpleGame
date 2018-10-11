package com.d3m1d0v.somesimplegame.game.engines;

import com.d3m1d0v.somesimplegame.game.Entity;
import com.d3m1d0v.somesimplegame.game.EntityState;
import com.d3m1d0v.somesimplegame.game.Vector2D;

import java.util.ArrayList;
import java.util.List;

public class PhysicsEngine {

    public static Vector2D<Integer> gravityDirection = new Vector2D<>(0, -1);

    public List<Entity> allEntities = new ArrayList<>();
    public List<Entity> materialEntities = new ArrayList<>();
    public List<Entity> movementEntities = new ArrayList<>();

    public void start() {
    }

    public void nextTick() {
        // TODO: implement collisions
        movementEntities.forEach(entity -> {
            if (entity.state == EntityState.MOVE) {
                entity.position.X += entity.direction.X * 0.001;
                entity.position.Y += entity.direction.Y * 0.001;
            }
        });
    }

    public void addEntity(Entity entity) {
        allEntities.add(entity);

        if (entity.isMaterial) {
            materialEntities.add(entity);
        }

        if (entity.isMovement) {
            movementEntities.add(entity);
        }
    }
}
