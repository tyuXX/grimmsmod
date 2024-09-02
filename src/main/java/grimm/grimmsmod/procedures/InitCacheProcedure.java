package grimm.grimmsmod.procedures;

import net.neoforged.fml.loading.FMLPaths;

import java.io.File;

import grimm.grimmsmod.GrimmsMod;

public class InitCacheProcedure {
	public static void execute() {
		GrimmsMod.LOGGER.info("Initializing Grimm's mod cache.");
		{
			File dir_files_ = new File((FMLPaths.GAMEDIR.get().toString() + "/grimms/custom/"));
			if (dir_files_.isDirectory())
				for (File file : dir_files_.listFiles()) {
					String stringiterator = file.getPath();
					GrimmsMod.LOGGER.info(stringiterator);
					InitCacheFileProcedure.execute(stringiterator);
				}
		}
	}
}
