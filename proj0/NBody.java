/**
 * The goal of this class is to simulate a universe specified in one of the data files. 
 */

public class NBody {

    public static double readRadius(String planetsTxtPath)
    {
        In in = new In(planetsTxtPath);

        int numOfPlanets = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String planetsTxtPath)
    {
        In in = new In(planetsTxtPath);

        int numOfPlanets = in.readInt();
        double radius = in.readDouble();

        Planet[] allPlanets = new Planet[numOfPlanets];
        for(int i = 0; i < numOfPlanets; ++i)
        {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();

            allPlanets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);

        }

        return allPlanets;
    }

    public static void main(String[] args) {

        // if (args.length == 0) {
		// 	System.out.println("Please T, dt, filename as a command line argument.");
		// 	/* NOTE: Please don't use System.exit() in your code.
		// 	   It will break the autograder. */
		// 	System.exit(0);
		// }

		double T = Double.valueOf(args[0]);
		double dt = Double.valueOf(args[1]);	
		String filename = args[2];
		double r = readRadius(filename);
		Planet[] planets = readPlanets(filename);

		// set the universe scale
		StdDraw.setXscale(-r, r);
		StdDraw.setYscale(-r, r);
		StdDraw.enableDoubleBuffering();

		double t = 0;
		int num = planets.length;
		while(t <= T){
			double[] xForces = new double[num];
			double[] yForces = new double[num];
			for(int i = 0; i < num; i++){
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}
			for(int i = 0; i < num; i++){
				planets[i].update(dt, xForces[i], yForces[i]);
			}

			// draw the backgroud picture
			StdDraw.picture(0, 0, "images/starfield.jpg");

			// draw all the planets
			for (Planet planet : planets) {
				planet.draw();	
			}

			StdDraw.show();
			StdDraw.pause(10);
			t += dt;
		}

		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", r);
		for (int i = 0; i < planets.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
            planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
		}
	}

}
