package service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ProblemSolver765 {
	public static int execute(String[] items){
		List<Cluster> clusters = new ArrayList<>();
		for(int i=0; i<items.length; i++){
			String[] currentItems = items[i].split(" ");
			boolean existInCluster = false;
			for (Cluster cluster : clusters) {
				HashSet<String> clusterCities = cluster.getConnectableCities();
				if(clusterCities.contains(currentItems[0]) || clusterCities.contains(currentItems[1])){
					existInCluster = true;
					clusterCities.add(currentItems[0]);
					clusterCities.add(currentItems[1]);
					break;
				}
			}
			if(existInCluster == false){
				Cluster newCluster = new Cluster();
				newCluster.getConnectableCities().add(currentItems[0]);
				newCluster.getConnectableCities().add(currentItems[1]);
				clusters.add(newCluster);
			}
		}
		int biggestCluster = 0;
		for (Cluster cluster : clusters) {
			if(biggestCluster < cluster.getConnectableCities().size()){
				biggestCluster = cluster.getConnectableCities().size();
			}
		}
		return biggestCluster;
	}
	
	private static class Cluster{
		HashSet<String> connectableCities;
		
		public Cluster(){
			this.connectableCities = new HashSet<>();
		}
		
		public HashSet<String> getConnectableCities(){
			return this.connectableCities;
		}
	}
}
