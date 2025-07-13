class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        
        int playerPointer = players.length - 1;
        int trainerPointer = trainers.length - 1;
        int count = 0;
        
        while (playerPointer >= 0 && trainerPointer >= 0) {
            if (trainers[trainerPointer] >= players[playerPointer]) {
                count++;
                trainerPointer--;
            }
            playerPointer--;
        }
        
        return count;
    }
}
