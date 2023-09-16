package RoboJJ;
import robocode.*;
import java.awt.Color;

public class RoboJV extends Robot{
	public void run() {
	//Definindo as cores do robo:
		setColors(Color.black,Color.red,Color.white,Color.red,Color.black);
		while(true){
			ahead(80); // O robo andará 80 pixels a frente
			turnGunLeft(180); // O robo irá girar em 70 graus o canhão
			turnRight(90); // O robo irá girar em 90 graus a esquerda
			back(50); // O robo andará 50 pixels para trás
			turnGunRight(180); // O robo irá girar o canhão 45 graus a direita
		}
	}	
	//Detecta robô inimigo:
	public void onScannedRobot(ScannedRobotEvent e) {
		String robozito = e.getName(); // Esse metodo obtém o nome do robo detectado pelo radar e a variavel armazenaarmazena.
		double distancia = e.getDistance(); // Esse metodo obtem a distancia em pixel do robo inimigo detectado.
		System.out.println(robozito + " distância " + distancia); // Essa linha vai imprimir no termina o nome do robo inimigo detectado e a distância que ele tá do meu robo.
		fire(1);
		if(distancia < 135){ // Esse valor que to usando como distancia do robo inimigo pro meu, se ele tiver menor de 135 pixels do meu robo ele irá disparar o canhão com a força máxima (3). 
			fire(3);
		} else {
			fire(1); // Se o robo inimigo não estiver dentro da distancia estabelecida, meu robo irá disparar apenas na força padrão (1).
		}
}
	//Colisão com a parede:
	public void onHitByBullet(HitByBulletEvent e) {

		back(30); // Se o robo bater ele irá recuar 30 pixels.
		turnRight(90); // Se bater irá girar 90 graus a direita.
}
}