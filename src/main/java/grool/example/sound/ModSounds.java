package grool.example.sound;

import grool.example.Grool;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static final SoundEvent CUSTOM_SOUND = registerSoundEvent("custom_sound"); // test

    public static final SoundEvent TARD_BLOCK_BREAK = registerSoundEvent("tard_block_break");
    public static final SoundEvent TARD_BLOCK_STEP = registerSoundEvent("tard_block_step");
    public static final SoundEvent TARD_BLOCK_PLACE = registerSoundEvent("tard_block_place");
    public static final SoundEvent TARD_BLOCK_HIT = registerSoundEvent("tard_block_hit");
    public static final SoundEvent TARD_BLOCK_FALL = registerSoundEvent("tard_block_fall");

    public static final BlockSoundGroup GROOL_STONE_BRICK_BLOCK_GROUP = new BlockSoundGroup(
            1.0F, // Volume
            1.0F, // Pitch
            ModSounds.TARD_BLOCK_BREAK,
            ModSounds.TARD_BLOCK_STEP,
            ModSounds.TARD_BLOCK_PLACE,
            ModSounds.TARD_BLOCK_HIT,
            ModSounds.TARD_BLOCK_FALL
    );


    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(Grool.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }


    public static void  registerSounds() {
        // This method is intentionally left empty for now.
        // Sound registration can be added here in the future if needed.

    }
}
