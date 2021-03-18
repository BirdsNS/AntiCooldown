package de.tubeof.ac.listener;

import de.tubeof.ac.data.Data;
import de.tubeof.ac.enums.SettingsType;
import de.tubeof.ac.main.AntiCooldown;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class SweepAttack implements Listener {

    private Data data = AntiCooldown.getData();

    @EventHandler
    public void onSweep(EntityDamageByEntityEvent event) {
        if(!data.getBooleanSettings(SettingsType.DISABLE_SWEEP_ATTACK)) return;
        if(event.getCause() != EntityDamageEvent.DamageCause.ENTITY_SWEEP_ATTACK) return;;
        event.setCancelled(true);
    }
}
