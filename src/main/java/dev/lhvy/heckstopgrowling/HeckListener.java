package dev.lhvy.heckstopgrowling;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Tameable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class HeckListener implements Listener {
    @EventHandler
    public void onAttack(EntityDamageByEntityEvent e) {
        Entity entity = e.getEntity();
        Entity damager = e.getDamager();
        if (entity instanceof Tameable) {
            if (damager instanceof Projectile && ((Projectile) damager).getShooter() instanceof Player) {
                Projectile proj = (Projectile) damager;
                damager = (Entity) proj.getShooter();
                proj.remove();
            }
            Tameable pet = (Tameable) entity;
            if (pet.isTamed() && damager instanceof Player) {
                e.setCancelled(true);
            }
        }
    }
}
