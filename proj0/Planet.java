public class Planet {


    /**
     * Some instance variables of a planet
     */
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;

    public String imgFileName;



    private static final double G = 6.67e-11;


    /**
     * Take in a Planet object and initialize an identical Planet object.
     * @param p
     */
    public Planet(Planet p)
    {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    /**
     * Take in all of the instance variables of a planet
     * and initialize the Planet object.
     * @param xxPos
     * @param yyPos
     * @param xxVel
     * @param yyVel
     * @param mass
     * @param imgFilename
     */
    public Planet(double xxPos, double yyPos, double xxVel, double yyVel,
                    double mass, String imgFileName)
    {
        this.xxPos = xxPos;
        this.yyPos = yyPos;
        this.xxVel = xxVel;
        this.yyVel = yyVel;
        this.mass = mass;
        this.imgFileName = imgFileName;
    }


    public double calcDistance(Planet p)
    {
        return Math.sqrt(
            (xxPos - p.xxPos)*(xxPos - p.xxPos)
            +
            (yyPos - p.yyPos)*(yyPos - p.yyPos)
        );
    }

    public double calcForceExertedBy(Planet p)
    {
        double r = calcDistance(p);
        double F = (G * mass * p.mass) / (r * r);
        return F;
    }

    public double calcForceExertedByX(Planet p)
    {
        double dx = p.xxPos - xxPos;
        double r = calcDistance(p);
        double cosTheta = dx / r;
        double F = calcForceExertedBy(p);
        double Fx = F * cosTheta;
        return Fx;
    }

    public double calcForceExertedByY(Planet p)
    {
        double dy = p.yyPos - yyPos;
        double r = calcDistance(p);
        double sinTheta = dy / r;
        double F = calcForceExertedBy(p);
        double Fy = F * sinTheta;
        return Fy;
    }

    public double calcNetForceExertedByX(Planet[] allPlanets)
    {
        double netFx = 0;
        for(Planet p : allPlanets)
        {
            if(p.equals(this))  continue;
            else
            {
                double Fpx = calcForceExertedByX(p);
                netFx += Fpx;
            }
        }

        return netFx;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets)
    {
        double netFy = 0;
        for(Planet p : allPlanets)
        {
            if(p.equals(this))  continue;
            else
            {
                double Fpy = calcForceExertedByY(p);
                netFy += Fpy;
            }
        }

        return netFy;
    }

    public void update(double dt, double netFx, double netFy)
    {
        double ax = netFx / mass;
        double ay = netFy / mass;

        xxVel += ax * dt;
        yyVel += ay * dt;

        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    }


    public void draw(){
		StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
	}

}

