package dev.negativekb.itembase64.commands;

import dev.negativekb.itembase64.utils.BukkitSerializer;
import dev.negativekb.itembase64.utils.HasteBin;
import lombok.SneakyThrows;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandToBase64 implements CommandExecutor {
    @SneakyThrows
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if ((!(sender instanceof Player))) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command.");
            return true;
        }

        Player player = (Player) sender;
        ItemStack itemInHand = player.getItemInHand();
        if (itemInHand == null || itemInHand.getType().equals(Material.AIR)) {
            sender.sendMessage(ChatColor.RED + "You must be holding an Item.");
            return true;
        }

        String code = BukkitSerializer.itemStackArrayToBase64(new ItemStack[]{itemInHand});

        player.sendMessage(ChatColor.GREEN + "Processing...");

        String link = new HasteBin().post(code, true);
        player.sendMessage(ChatColor.GREEN + "Finished! " + ChatColor.YELLOW + link);

        return true;
    }
}
