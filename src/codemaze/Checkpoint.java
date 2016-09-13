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
		
		if(labProps.getProperty(Constants.LabPropertyKeys.UID) != null) {
			if (labProps.getProperty(Constants.LabPropertyKeys.ENTRANCE) != null) {
				if(labProps.getProperty(Constants.LabPropertyKeys.BINARY) != null) {
					if(labProps.getProperty(Constants.LabPropertyKeys.TEA_CUPS) !=  null) {
						if(labProps.getProperty(Constants.LabPropertyKeys.SPHINX) != null) {
							if(labProps.getProperty(Constants.LabPropertyKeys.TUMBLERS) != null) {
								if(labProps.getProperty(Constants.LabPropertyKeys.GUARD) != null) {
									return SpawnPoint.FINISH;
								}
								return SpawnPoint.GUARD;
							}
							return SpawnPoint.PUZZLE_WALL;
						}
						return SpawnPoint.SPHINX;
					}
					return SpawnPoint.TEA_CUPS;
				}
				return SpawnPoint.BINARY_SEARCH;
			}
			return SpawnPoint.ENTRANCE;
		}
		return SpawnPoint.ENTRANCE;
	}
}
