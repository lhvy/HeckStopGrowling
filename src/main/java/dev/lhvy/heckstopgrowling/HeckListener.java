package dev.lhvy.heckstopgrowling;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Tameable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.projectiles.ProjectileSource;

public class HeckListener implements Listener {
    @EventHandler
    public void onTamedAttack(EntityDamageByEntityEvent event) {
        if (hasTamedDefender(event) && hasAttackingPlayer(event)) {
            event.setCancelled(true);
        }
    }

    private boolean hasTamedDefender(EntityDamageByEntityEvent event) {
        return event.getEntity() instanceof Tameable tameable && tameable.isTamed();
    }

    private boolean hasAttackingPlayer(EntityDamageByEntityEvent event) {
        Entity attacker = event.getDamager();
        if (attacker instanceof Projectile projectile) {
            ProjectileSource source = projectile.getShooter();
            if (source instanceof Player player) {
                projectile.remove();
                return true;
            }
        }
        return attacker instanceof Player;
    }
}
