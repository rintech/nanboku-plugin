package com.densyakun.ns;

import java.util.UUID;

public class UUIDandInteger {
	private UUID uuid;
	public byte time;

	public UUIDandInteger(UUID uuid, byte time) {
		this.uuid = uuid;
		this.time = time;
	}

	public UUID getUniqueID() {
		return uuid;
	}
}
