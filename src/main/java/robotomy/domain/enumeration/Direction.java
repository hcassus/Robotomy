package robotomy.domain.enumeration;

public enum Direction {
  NORTH(0, 1),
  EAST(1, 0),
  SOUTH(0, -1),
  WEST(-1, 0);

  private Integer xPositionOffset;
  private Integer yPositionOffset;

  Direction(Integer xPositionOffset, Integer yPostitionOffset) {
    this.xPositionOffset = xPositionOffset;
    this.yPositionOffset = yPostitionOffset;
  }

  public Integer getPositionOffsetX() {
    return xPositionOffset;
  }

  public Integer getPositionOffsetY() {
    return yPositionOffset;
  }

}
