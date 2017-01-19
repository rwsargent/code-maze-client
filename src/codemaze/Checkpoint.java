package codemaze;

import java.util.Properties;

public class Checkpoint {

	public static SpawnPoint returnCheckpoint() {
		Properties labProps = null;
		try {
			labProps = PropertyHandler.getProperties();
		} catch (MazeException e) {
			return SpawnPoint.ENTRANCE;
		}

		if (labProps.getProperty(Constants.LabPropertyKeys.UID) != null) {
			if (labProps.getProperty(Constants.LabPropertyKeys.ENTRANCE) != null) {
				if (labProps.getProperty(Constants.LabPropertyKeys.TEA_CUPS) != null) {
					if (labProps.getProperty(Constants.LabPropertyKeys.SPHINX) != null) {
						if (labProps.getProperty(Constants.LabPropertyKeys.TUMBLERS) != null) {
							if (labProps.getProperty(Constants.LabPropertyKeys.CHAIN) != null) {
								if (labProps.getProperty(Constants.LabPropertyKeys.PASSWORD) != null) {
									if (labProps.getProperty(Constants.LabPropertyKeys.BINARY) != null) {
										return SpawnPoint.FINISH;
									}
									return SpawnPoint.BINARY_SEARCH;
								}
								return SpawnPoint.PASSWORD;
							}
							return SpawnPoint.CHAIN;
						}
						return SpawnPoint.PUZZLE_WALL;
					}
					return SpawnPoint.SPHINX;
				}
				return SpawnPoint.TEA_CUPS;
			}
			return SpawnPoint.ENTRANCE;
		}
		return SpawnPoint.ENTRANCE;
	}
}
