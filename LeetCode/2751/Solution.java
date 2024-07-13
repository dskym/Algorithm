class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;

        List<Robot> robotList = new ArrayList();
        for(int i=0;i<n;++i) {
            robotList.add(new Robot(i, positions[i], healths[i]));
        }
        Collections.sort(robotList, (a, b) -> a.getPosition()-b.getPosition());

        Stack<Robot> stack = new Stack<>();
        for(Robot robot : robotList) {
            if('L' == directions.charAt(robot.getIndex())) {
                boolean flag = true;
                while(!stack.isEmpty()) {
                    Robot top = stack.peek();
                    if(directions.charAt(top.getIndex()) == directions.charAt(robot.getIndex())) {
                        break;
                    }
                    if(top.getHealth() > robot.getHealth()) {
                        top.minusHealth();
                        flag = false;
                        break;
                    } else if(top.getHealth() == robot.getHealth()) {
                        stack.pop();
                        flag = false;
                        break;
                    } else {
                        robot.minusHealth();
                        stack.pop();
                    }
                }
                if(flag) {
                    stack.push(robot);
                }
            } else {
                stack.push(robot);
            }
        }

        List<Robot> result = new ArrayList();
        while(!stack.isEmpty()) {
            result.add(stack.peek());
            stack.pop();
        }
        Collections.sort(result, (a, b) -> a.getIndex()-b.getIndex());
        return result.stream().map(r -> r.getHealth()).toList();
    }
}

class Robot {
    int index;
    int position;
    int health;

    public Robot(int index, int position, int health) {
        this.index = index;
        this.position = position;
        this.health = health;
    }

    public int getIndex() {
        return this.index;
    }

    public int getPosition() {
        return this.position;
    }

    public int getHealth() {
        return this.health;
    }

    public void minusHealth() {
        this.health--;
    }
}
