package model;

public class EquipmentBean {
    private int equipmentId;
    private int microphone;
    private int podium;
    private int screen;
    private int lcdProjector;
    private int whiteboard;

    // コンストラクタ
    public EquipmentBean(int microphone, int podium, int screen, int lcdProjector, int whiteboard) {
        this.microphone = microphone;
        this.podium = podium;
        this.screen = screen;
        this.lcdProjector = lcdProjector;
        this.whiteboard = whiteboard;
    }

    public EquipmentBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	// ゲッターとセッター
    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public int getMicrophone() {
        return microphone;
    }

    public void setMicrophone(int microphone) {
        this.microphone = microphone;
    }

    public int getPodium() {
        return podium;
    }

    public void setPodium(int podium) {
        this.podium = podium;
    }

    public int getScreen() {
        return screen;
    }

    public void setScreen(int screen) {
        this.screen = screen;
    }

    public int getLcdProjector() {
        return lcdProjector;
    }

    public void setLcdProjector(int lcdProjector) {
        this.lcdProjector = lcdProjector;
    }

    public int getWhiteboard() {
        return whiteboard;
    }

    public void setWhiteboard(int whiteboard) {
        this.whiteboard = whiteboard;
    }
}
