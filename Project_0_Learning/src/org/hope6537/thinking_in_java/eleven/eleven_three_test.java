package org.hope6537.thinking_in_java.eleven;

import java.util.Arrays;
import java.util.List;

class Snow {
}

class Powder extends Snow {
};

class Light extends Powder {
};

class Heavy extends Powder {
};

class Crusty extends Snow {
};

class Slush extends Snow {
};

public class eleven_three_test {

	public static void main(String[] args) {
		List<Snow> list = Arrays.<Snow> asList(new Light(), new Heavy());
	}

}
