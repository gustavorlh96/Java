public class Principal {

	public static void main(String[] args) {
		Mec m1 = new Mec();
		
		UnivPublica uniPub1 = new UnivPublica("UFRGS", 3000, 60, "RS");
		UnivPublica uniPub2 = new UnivPublica("USP", 5000, 100, "SP");
		UnivPublica uniPub3 = new UnivPublica("UFSC", 2300, 46, "SC");
		
		UnivPrivada uniPriv1 = new UnivPrivada("Unisinos", 2800, 56, 2350);
		UnivPrivada uniPriv2 = new UnivPrivada("LaSalle", 1800, 36, 1850);
		UnivPrivada uniPriv3 = new UnivPrivada("PUCRS", 3500, 70, 2650);
		
		m1.credenciaUniversidade(uniPub1);
		m1.credenciaUniversidade(uniPub2);
		m1.credenciaUniversidade(uniPub3);
		m1.credenciaUniversidade(uniPriv1);
		m1.credenciaUniversidade(uniPriv2);
		m1.credenciaUniversidade(uniPriv3);
		
		m1.imprimeUniversidades();
		
		m1.universidadeMaisCara();
		
		m1.universidadesDoSul();
		
		m1.descredenciaUniversidade(uniPriv1);
		m1.descredenciaUniversidade(uniPriv2);
		m1.descredenciaUniversidade(uniPriv3);
		
		m1.universidadeMaisCara();
		
		m1.descredenciaUniversidade(uniPub1);
		m1.descredenciaUniversidade(uniPub2);
		m1.descredenciaUniversidade(uniPub3);
		
		m1.universidadesDoSul();
	}
}