package fr.jblusitsme.furnace;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.material.Furnace;

import java.util.Iterator;

public class FurnaceCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            return false;
        }
        Player player = (Player) sender;
        ItemStack result = null;
        final ItemStack baseItem = player.getItemInHand();
        final Iterator<Recipe> i = Bukkit.recipeIterator();
        while(i.hasNext()) {
            Recipe r = i.next();
            if(!(r instanceof FurnaceRecipe)) continue;
            FurnaceRecipe fr = (FurnaceRecipe)r;
            if(fr.getInput().getType() != baseItem.getType()) continue;
            result = fr.getResult();
            break;
        }
        if(result != null) {
            sender.sendMessage("§aItem cuit §ex"+baseItem.getAmount()+" "+baseItem.getType().name());
            player.getInventory().setItemInHand(result);
        } else {
            sender.sendMessage("§cCet item ne peut pas être cuit.");
        }
        return false;
    }
}
